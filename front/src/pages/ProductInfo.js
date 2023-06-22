import { useDispatch, useSelector } from "react-redux";
import ProductManageSide from "../layouts/ProductManageSide";
import ProductInfoCSS from "./ProductInfoCSS.module.css"
import { useNavigate, useParams } from "react-router-dom";
import { useEffect } from "react";
import { GET_PRODUCT } from "../modules/ProductFindModule";
import { getProductInfoAPI } from "../apis/ManageProductAPICALL";

function ProductInfo() {

    const dispatch = useDispatch();
    const navigate = useNavigate();
    const { productNo } = useParams();
    const { products, product } = useSelector(state => state.productFindReducer);

    useEffect(
        () => {
            console.log(productNo);
            dispatch(getProductInfoAPI(productNo));
        },[]
    );

    return (
        <>
            <ProductManageSide/>
            <div className={ProductInfoCSS.area}>
                <div>제품번호 : {product.productNo}</div>
                <div>제품명 : {product.productName}</div>
                <div>가격 : {product.productPrice}</div>
                <div>종류 : {product.productCategory.productCategoryName}</div>
            </div>
        </>
    );
}

export default ProductInfo;