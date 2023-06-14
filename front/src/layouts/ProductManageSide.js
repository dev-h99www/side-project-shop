import { NavLink } from 'react-router-dom';
import ProductManageSideCSS from './ProductManageSideCSS.module.css';

function ProductManageSide() {

    return (
        <div className={ProductManageSideCSS.area}>
            <div className={ProductManageSideCSS.side}>
                <NavLink to="/product/manage"><div className={ProductManageSideCSS.side_content}>상품조회</div></NavLink>
                <NavLink to="/product/manage/regist"><div className={ProductManageSideCSS.side_content}>상품등록</div></NavLink>
            </div>
        </div>
    );
}

export default ProductManageSide;