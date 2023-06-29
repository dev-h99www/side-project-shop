function ProductCategoryIndex({categoryInfo}) {
    const {productCategoryNo, productCategoryName} = categoryInfo;
    
    return(
        <option
            value={productCategoryNo}
        >
            {productCategoryName}
        </option>      
    );
};

export default ProductCategoryIndex;