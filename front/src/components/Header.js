import { NavLink } from "react-router-dom";
import HerderCSS from "./HeaderCSS.module.css";

function Header() {

    return (
        <div className={ HerderCSS.headergroup}>
            <div className={HerderCSS.body}>
                <NavLink to="/">홈</NavLink>
                <NavLink to="/product/manage">구매내역</NavLink>
            </div>

        </div>
    );

}

export default Header;