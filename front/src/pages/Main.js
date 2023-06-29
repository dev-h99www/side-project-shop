import { useDispatch, useSelector } from 'react-redux';
import MainCSS from './MainCSS.module.css';
import { findProductCountAPI, findProductsAPI } from '../apis/ManageProductAPICALL';
import { useEffect } from 'react';

function Main() {

    const dispatch = useDispatch();
    const { products, pageInfo } = useSelector(state => state.productFindReducer);
    const { page, totalItemCount, pageItemCount } = pageInfo;
    
    
    useEffect(
        () => {
            dispatch(findProductsAPI(pageInfo));
        },[]
    );

    return (
        <>
            <h1>mainpage</h1>
        </>
    );
}

export default Main;