import { useDispatch, useSelector } from "react-redux";
import ProductManageSide from "../layouts/ProductManageSide";
import ProductInfoCSS from "./ProductInfoCSS.module.css"
import { useNavigate, useParams } from "react-router-dom";
import { useEffect } from "react";
import { getProductInfoAPI } from "../apis/ManageProductAPICALL";
import { Cookies } from "react-cookie";
import jwtDecode from "jwt-decode";
import ProductPurchase from "../components/ProductPurchase";

function ProductInfo() {

    const dispatch = useDispatch();
    const navigate = useNavigate();
    const { productNo } = useParams();
    const { products, product } = useSelector(state => state.productFindReducer);
    const cookies = new Cookies();
    const token = cookies.get('token');
    let isLogin = false;
    let memberRole = "";

    useEffect(
        () => {
            dispatch(getProductInfoAPI(productNo));
        },[]
    );

    if(token) {
        const decoded = jwtDecode(token);
        isLogin = true;
        memberRole = decoded.memberRole;
    }

    return (
        <>
            { memberRole == "ROLE_ADMIN" ? <ProductManageSide/> : null }
            <div className={ProductInfoCSS.area}>
                <div className={ ProductInfoCSS.listbox}>제품번호 : {product.productNo}</div>
                <div className={ ProductInfoCSS.listbox}>제품명 : {product.productName}</div>
                <div className={ ProductInfoCSS.listbox}>가격 : {product.productPrice}원</div>
                <div className={ ProductInfoCSS.listbox}>종류 : {product.productCategory.productCategoryName}</div>
                { memberRole == "ROLE_USER" ? <ProductPurchase/> : null }
            </div>

        </>
    );
}

export default ProductInfo;