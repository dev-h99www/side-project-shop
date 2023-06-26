import { Outlet } from 'react-router-dom';
import LayoutCSS from './LayoutCSS.module.css';
import AdminHeader from '../components/AdminHeader';
import Header from '../components/Header';
import Login from '../pages/Login';
import { Cookies } from 'react-cookie';
import jwtDecode from 'jwt-decode';

function Layout() {

    const cookies = new Cookies();
    const token = cookies.get('token');
    let isLogin = false;
    let isAdmin = false;
    
    if(token) {

        const decoded = jwtDecode(token);
        isLogin = true;
        isAdmin = (decoded.memberRole == 'ROLE_ADMIN');
    }


    if(!isLogin) {
        return (
            <Login/>
        );
    }
    if(isAdmin) {

        return (
            <div className={LayoutCSS.wrapper}>
                <AdminHeader/>
                <Outlet/>
            </div>
        );
    } else {

        return (
            <div className={LayoutCSS.wrapper}>
                <Header/>
                <Outlet/>
            </div>
        );
    }

}

export default Layout;