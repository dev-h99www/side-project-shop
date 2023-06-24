import { NavLink } from "react-router-dom";
import HerderCSS from "./HeaderCSS.module.css";
import { setCookie } from "../cookies/cookie";

function Header() {

    const logoutHandler = () => {
        setCookie('token', '', {expires: new Date()});
        window.location.replace('/');
    }

    return (
        <div className={ HerderCSS.headergroup}>
            <div className={HerderCSS.body}>
                <NavLink to="/"><span className={ HerderCSS.home }>홈</span></NavLink>
                <NavLink to="/products/history"><span className={ HerderCSS.menu }>구매내역</span></NavLink>
                <NavLink to="/deliveries/history"><span className={ HerderCSS.menu }>배송조회</span></NavLink>
                <NavLink to="/"><span className = { HerderCSS.logout} onClick= { logoutHandler }>로그아웃</span></NavLink>
            </div>

        </div>
    );

}

export default Header;