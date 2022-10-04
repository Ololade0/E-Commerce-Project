package africa.semicolon.lumexpress.service;

import africa.semicolon.lumexpress.data.dto.request.AddProductRequest;
import africa.semicolon.lumexpress.data.dto.request.GetAllItemstRequest;
import africa.semicolon.lumexpress.data.dto.request.UpdateProductRequest;
import africa.semicolon.lumexpress.data.dto.response.AddProductResponse;
import africa.semicolon.lumexpress.data.dto.response.UpdateProductResponse;
import africa.semicolon.lumexpress.data.model.Category;
import africa.semicolon.lumexpress.data.model.Product;
import africa.semicolon.lumexpress.data.repository.ProductRepository;
import africa.semicolon.lumexpress.exception.ProductNotFoundException;
import africa.semicolon.lumexpress.service.cloud.CloudService;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
@Builder
@Slf4j
public class ProductServiceImpl implements ProductServices {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final CloudService cloudService;


    @Override
    public AddProductResponse addProduct(AddProductRequest createProductRequest) throws IOException {
        Product mapProduct = modelMapper.map(createProductRequest, Product.class);
        mapProduct.getCategories().add(Category.valueOf(createProductRequest.getCategory().toUpperCase()));
        var imageUrl = cloudService.upload(createProductRequest.getImage().getBytes(), ObjectUtils.emptyMap());
        log.info("Cloudinary image url:: {}", imageUrl);
        mapProduct.setImageUrl(imageUrl);
        Product savedProduct = productRepository.save(mapProduct);
        return buildCreateProductResponse(savedProduct);
    }

    private AddProductResponse buildCreateProductResponse(Product savedProduct) {
            return AddProductResponse.builder()
                    .code(201)
                    .productId(savedProduct.getId())
                    .message("product added successfully")
                    .build();

        }


    @Override
    public UpdateProductResponse updateProductDetails(UpdateProductRequest updateProductRequest){
        productRepository.findById(updateProductRequest.getProductId()).orElseThrow(()-> new ProductNotFoundException(
                String.format("product with id %d not found" ,updateProductRequest.getProductId())
        ));
      return null;
    }
//THe first way of getting productbyid
//    @Override
//    public Product getProductById(Long id) {
//       Optional<Product> foundProduct = productRepository.findById(id);
//       if(foundProduct.isPresent())
//           return foundProduct.get();
//       throw  new ProductNotFoundException(String.format("Product with id %d not found", id));
//      }

    //THe second way of getting productbyid
        @Override
    public Product getProductById(Long id) {
       return  productRepository.findById(id).orElseThrow(
               ()-> new ProductNotFoundException(
                       String.format("product with id %d not found", id)));

     }

    @Override
    public Page<Product> getAllProducts(GetAllItemstRequest getAllItemstRequest) {
        Pageable pageable = PageRequest.of(getAllItemstRequest.getPageNumber()-1, getAllItemstRequest.getNumberOfItemsProductsPerPage());
       Page<Product> products =  productRepository.findAll(pageable);
        return products;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}
