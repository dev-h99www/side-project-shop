import { NavLink } from "react-router-dom";
import AdminHerderCSS from "./AdminHeaderCSS.module.css";

function AdminHeader() {

    return (
        <div className={ AdminHerderCSS.headergroup}>
            <div className={AdminHerderCSS.body}>
                <NavLink to="/"><span className={ AdminHerderCSS.home }>홈</span></NavLink>
                <NavLink to="/product/manage"><span className={ AdminHerderCSS.menu }>상품관리</span></NavLink>
                <NavLink to="/delevery/manage"><span className={ AdminHerderCSS.menu }>배송관리</span></NavLink>
            </div>
        </div>
    );

}

export default AdminHeader;