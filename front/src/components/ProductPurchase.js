import { useNavigate, useParams } from 'react-router-dom';
import ProductPurchaseCSS from './ProductPurchaseCSS.module.css';
import { useDispatch, useSelector } from 'react-redux';
import { SET_PRODUCT_AMOUNT } from '../modules/PurchaseModule';
import { useEffect } from 'react';
import { Cookies } from 'react-cookie';
import jwtDecode from 'jwt-decode';
import { registPurchaseAPI } from '../apis/PurchaseAPICALL';

function ProductPurchase() {

  const {productNo} = useParams();
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const {registInfo, registResult} = useSelector(state => state.purchaseReducer);
  const {product} = useSelector(state => state.productFindReducer)
  const {amount} = registInfo;

  const cookies = new Cookies();
  const token = cookies.get('token');
  const decoded = jwtDecode(token);

  useEffect(() => {
    dispatch({type:SET_PRODUCT_AMOUNT, payload:1})
    },[]
  );

  useEffect(() => {
  
  },[registResult.result]);

  const onClickHandler = async () => {
    const purchaseInfo = {
      memberNo: decoded.memberNo,
      amount: amount,
      productNo: productNo,
      totalPrice: product.productPrice * amount
    };
    await dispatch(registPurchaseAPI(purchaseInfo));
    if(registResult.result) {
      window.location.replace(`/`);
      //check window.location.replace(`/purchases/${registResult.registInfo.purchaseNo}`);
    }
  };

  return (
    <div>
      <input type="number" min="1" step="1" value={amount}
        onChange={ e => dispatch({type:SET_PRODUCT_AMOUNT, payload:e.target.value})}
        className={ProductPurchaseCSS.amountInput}
      />
      <button type="button" onClick={ onClickHandler } className={ProductPurchaseCSS.btn}>
        구매
      </button>
      <div className={ProductPurchaseCSS.total}>
        총 금액 : {product.productPrice * amount}원
      </div>
    </div>
  )

}

export default ProductPurchase;