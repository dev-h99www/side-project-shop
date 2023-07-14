import { useDispatch, useSelector } from 'react-redux';
import PurchasesListCSS from './PurchasesListCSS.module.css';
import { useEffect } from 'react';
import { Cookies } from 'react-cookie';
import jwtDecode from 'jwt-decode';
import { SET_USER_NO, PAGE_CHANGE } from '../modules/PurchaseModule';
import { getPurchasesAPI } from '../apis/PurchaseAPICALL';
import Pagination from 'react-js-pagination';
import styled from 'styled-components';
import PurchaseList from '../components/PurchaseList';

function PurchasesList() {

  const {userPurchases } = useSelector(state => state.purchaseReducer);
  const { searchInfo, purchases } = userPurchases;
  const { page, totalItemCount, pageItemCount, statusNo, categoryNo, searchValue } = searchInfo;

  const dispatch = useDispatch();

  useEffect(() => {
      const cookies = new Cookies();
      const token = cookies.get('token');
      const decoded = jwtDecode(token);
      dispatch({type: SET_USER_NO, payload:decoded.memberNo});    
      dispatch(getPurchasesAPI(searchInfo));
    },[]
  );

  const handlePageChange = async (e) => {
    await dispatch({type: PAGE_CHANGE, payload: e});
    await dispatch(getPurchasesAPI(searchInfo));

  }
  return (
    <div>
      <div className={PurchasesListCSS.toparea}>
      </div>
      <div className={PurchasesListCSS.listarea}>
        {purchases.map( purchase => <PurchaseList purchase={purchase} key={purchase.purchaseNo}/>)}
      </div>
      <div className={PurchasesListCSS.pagearea}>
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
export default PurchasesList;