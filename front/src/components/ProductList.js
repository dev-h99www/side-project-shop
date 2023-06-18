import { useNavigate } from "react-router-dom";
import ProductListCSS from "./ProductListCSS.module.css";

function ProductList ({product}) {

    const navigate = useNavigate();
    const {productNo, productName, productPrice, productCategory} = product;

    const onClickHandler = () => {
        navigate(`/product/manage/${productNo}`);
    };
    return (
        <div onClick= {onClickHandler}>
            {productNo}
            {productName}
            {productPrice}
            {productCategory.productCategoryName}
        </div>
    );
}

export default ProductList;