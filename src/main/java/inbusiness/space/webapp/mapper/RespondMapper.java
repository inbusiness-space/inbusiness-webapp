package inbusiness.space.webapp.mapper;
import inbusiness.space.webapp.domain.*;
import inbusiness.space.webapp.dto.*;
import org.mapstruct.Mapper;

/**
 * Created by fer on 29/07/2015.
 */
@Mapper(componentModel = "jsr330", uses = {BooleanMapper.class, DateMapper.class, ObjectIdMapper.class, IntMapper.class})
public interface RespondMapper {
//    RespondMapper INSTANCE = Mappers.getMapper(RespondMapper.class);

    MenuItems dtoToMenuItemTo(MenuItemsDto menuItemsDto);
    MenuItemsDto menuItemToDto(MenuItems menuItems);

    MenuTypes dtoToMenuTypes(MenuTypesDto menuTypesDto);
    MenuTypesDto menuTypesToDto(MenuTypes menuTypes);

    Pages dtoToPages(PagesDto pagesDto);
    PagesDto pagesToDto(Pages pages);

    PageTypes dtoToPageType(PageTypesDto pagesDto);
    PageTypesDto pageTypeToDto(PageTypes pages);

    Products dtoToProduct(ProductsDto productsDto);
    ProductsDto productToDto(Products products);

    RolesDto rolesToDto(Roles roles);
    Roles dtoToRoles(RolesDto rolesDto);

    Sites dtoToSites(SitesDto sitesDto);
    SitesDto sitesToDto(Sites sites);

    Transactions dtoToTransactions(TransactionsDto transactionsDto);
    TransactionsDto transactionToDto(Transactions transactions);

    Users dtoToUsers(UsersDto usersDto);
    UsersDto usersToDto(Users users);

    User dtoToUser(UsersDto usersDto);
    UsersDto userToDto(User users);

    Versions dtoToVersions(VersionsDto versionsDto);
    VersionsDto versionToDto(Versions versions);

    AssetMetaData dtoToAssetMetaData(AssetMetaDataDto assetDto);
    AssetMetaDataDto assetMetaDataToDto(AssetMetaData assetMetaData);

}
