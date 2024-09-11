package tpi.backend.e_commerce.mapper;

import tpi.backend.e_commerce.dto.SubCategoryDTO.CreateSubCategoryDTO;
import tpi.backend.e_commerce.dto.SubCategoryDTO.ResponseSubCategoryDTO;
import tpi.backend.e_commerce.models.Category;
import tpi.backend.e_commerce.models.SubCategory;
import java.util.List;

public class SubCategoryMapper {
    
    public static ResponseSubCategoryDTO toDTO(SubCategory subCategory){
        return new ResponseSubCategoryDTO(
            subCategory.getId(), subCategory.getName(), 
            subCategory.getDescription(), subCategory.getCategory().getName()
        );
    } 

   public static SubCategory toEntity(CreateSubCategoryDTO subCategoryDTO, Category category) {

        return new SubCategory(subCategoryDTO.getName(), subCategoryDTO.getDescription(), category);
    }

    public static List<ResponseSubCategoryDTO> toDTOList(List<SubCategory> subCategories){
        return subCategories.stream()
        .map(c -> SubCategoryMapper.toDTO(c))
        .toList();
    }

    public static SubCategory toUpdate(Long id, CreateSubCategoryDTO subCategoryDTO, Category category){
        
        return new SubCategory(id, subCategoryDTO.getName(), subCategoryDTO.getDescription(), category);
    }
    
}
