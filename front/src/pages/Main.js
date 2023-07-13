import { useDispatch, useSelector } from 'react-redux';
import { GET_CATEGORIES, PAGE_CHANGE, SET_CATEGORY, SET_PRODUCT_STATUS, SET_SEARCH_VALUE } from '../modules/ProductFindModule';
import MainCSS from './MainCSS.module.css';
import { findCategoriesAPI, findProductCountAPI, findProductsAPI } from '../apis/ManageProductAPICALL';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import ProductStatusIndex from '../components/ProductStatusIndex';
import ProductCategoryIndex from '../components/ProductCategoryIndex';
import ProductList from '../components/ProductList';
import Pagination from 'react-js-pagination';
import styled from 'styled-components';

function Main() {

    const dispatch = useDispatch();
    const { products, pageInfo, categories, productStatus } = useSelector(state => state.productFindReducer);
    const { page, totalItemCount, pageItemCount, statusNo, categoryNo, searchValue } = pageInfo;
    const navigate = useNavigate();

    
    useEffect(
        () => {
            dispatch({type: SET_PRODUCT_STATUS, payload: 1});
            dispatch(findProductsAPI(pageInfo));
            dispatch(findCategoriesAPI(GET_CATEGORIES));
        },[]
    );
    
    const onClickHandler = async () => {
        await dispatch(findProductsAPI(pageInfo));
    }

    const handlePageChange = async (e) => {

        await dispatch({type: PAGE_CHANGE, payload: e});
    
        await dispatch(findProductsAPI(pageInfo));
    };

    return (
        <div className={MainCSS.area}>
                <div className={MainCSS.toparea}>
                    <select onChange={ e => dispatch({type: SET_CATEGORY, payload: e.target.value}) }>
                        <option value='0' defaultValue>전체</option>
                        {
                            categories.map(categoryInfo => <ProductCategoryIndex categoryInfo={ categoryInfo } key={ categoryInfo.productCategoryNo }/>)
                        }
                    </select>
                    <input type="text"
                        onChange={ e => dispatch({type:SET_SEARCH_VALUE, payload:e.target.value}) }
                    />
                    <button onClick={ onClickHandler }>검색</button>
                </div>
                <div className={MainCSS.contentarea}>
                    {products.map( product => <ProductList url={"/products/"} product={product} key={product.productNo}/>)}
                </div>
                <div className={MainCSS.bottomarea}>
                    <PaginationBox>
                        <Pagination
                            activePage={page}
                            itemsCountPerPage={pageItemCount}
                            totalItemsCount={totalItemCount}
                            pageRangeDisplayed={5}
                            prevPageText="<"
                            nextPageText=">"
                            onChange={ handlePageChange }
                        />
                    </PaginationBox>
                </div>
            </div>
    );
}


const PaginationBox = styled.div`
  .pagination { display: flex; justify-content: center; margin-top: 15px;}
  ul { list-style: none; padding: 0; }
  ul.pagination li {
    display: inline-block;
    width: 30px;
    height: 30px;
    border: 1px solid #e2e2e2;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1rem; 
  }
  ul.pagination li:first-child{ border-radius: 5px 0 0 5px; }
  ul.pagination li:last-child{ border-radius: 0 5px 5px 0; }
  ul.pagination li a { text-decoration: none; color: black; font-size: 1rem; }
  ul.pagination li.active a { color: white; }
  ul.pagination li.active { background-color: #E2DDD3; }
  ul.pagination li a:hover,
  ul.pagination li a.active { color: #844F15; }
`

export default Main;