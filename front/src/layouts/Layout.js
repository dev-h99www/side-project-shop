import { Outlet } from 'react-router-dom';
import LayoutCSS from './LayoutCSS.module.css';
import AdminHeader from '../components/AdminHeader';
import Header from '../components/Header';
import Login from '../pages/Login';

function Layout() {

    let isLogin = true;
    let isAdmin = true;

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