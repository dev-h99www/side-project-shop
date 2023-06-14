import ProductManageCSS from './ProductManageCSS.module.css';
import ProductManageSide from '../layouts/ProductManageSide';

function ProductManage() {

    return (
        <>
            <ProductManageSide/>
            <div className={ProductManageCSS.area}>
                <div className={ProductManageCSS.toparea}></div>
                <div className={ProductManageCSS.contentarea}></div>
                <div className={ProductManageCSS.bottomarea}></div>
            </div>
        </>
    );
}

export default ProductManage;