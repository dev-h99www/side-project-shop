import { useNavigate } from "react-router-dom";
import ProductListCSS from "./ProductListCSS.module.css";

function ProductList ({product}) {

    const navigate = useNavigate();
    const {productNo, productName, productPrice, productCategory} = product;

    const onClickHandler = () => {
        navigate(`/product/manage/${productNo}`);
    };

    
    const onMouseOverHandler = (no) => {
        const tr = document.getElementById(no);
        tr.style.backgroundColor='black';
        tr.style.color='white';
        tr.style.cursor='pointer';
    };

    const onMouseOutHandler = (no) => {
        const tr = document.getElementById(no);
        tr.style.backgroundColor='white';
        tr.style.color='black';
    };

    return (
        <div className = {ProductListCSS.area}> 
            <table className = {ProductListCSS.tableArea}>
                <colgroup>
                    <col width = "10%"/>
                    <col width = "40%"/>
                    <col width = "30%"/>
                    <col width = "10%"/>
                    <col width = "10%"/>
                </colgroup>
                <tbody>
                    <tr 
                        onClick={onClickHandler}
                        onMouseOver={ () => onMouseOverHandler(productNo)}
                        onMouseOut={ () => onMouseOutHandler(productNo)}
                        id={productNo}
                    >
                        <td>{productNo}</td>
                        <td>{productName}</td>
                        <td>{productPrice}</td>
                        <td>{productCategory.productCategoryName}</td>
                        <td>{productCategory.productCategoryName}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default ProductList;