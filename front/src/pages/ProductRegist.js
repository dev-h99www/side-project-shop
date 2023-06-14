import { useDispatch, useSelector } from 'react-redux';
import ProductManageSide from '../layouts/ProductManageSide';
import ProductRegistCSS from './ProductRegistCSS.module.css';
import { useNavigate } from 'react-router-dom';
import { SET_NAME, SET_PRICE, SET_CATEGORY} from '../modules/ProductRegistModule';
import { findRegistProductInfoAPI, registProductAPI } from '../apis/ManageProductAPICALL';
import { useEffect } from 'react';
import RegistProductCategoryIndex from '../components/RegistProductCategoryIndex';

function ProductRegist () {

    const { name, category, price, no, categorys } = useSelector(state => state.productRegistReducer);
    const navigate = useNavigate();
    const dispatch = useDispatch();

    useEffect(
        () => {
           dispatch(findRegistProductInfoAPI());
        },[]
    );

    const onClickHandler = async () => {
        await dispatch(registProductAPI(name, category, price));

        if(no > 0) {
            alert('상품 등록 성공');
            // window.location.replace('/product/manage');
            navigate('/product/manage');
        }
    };

    return (
        <>
            <ProductManageSide/>
            
            <div className={ProductRegistCSS.area}>
                <div className={ProductRegistCSS.inputbox}>
                    <label>상품명 : </label>
                    <input type="text" value={ name }
                        onChange={ e => dispatch({type: SET_NAME, payload: e.target.value})}
                    />
                </div>
                <div className={ProductRegistCSS.inputbox}>
                    <label>카테고리 : </label>
                    <select defaultValue={ category } onChange={ e => dispatch({type: SET_CATEGORY, payload: e.target.value}) }>
                        {
                            categorys.map(categoryInfo => <RegistProductCategoryIndex categoryInfo={ categoryInfo } key={ categoryInfo.productCategoryNo }/>)
                        }
                    </select>
                </div>
                <div className={ProductRegistCSS.inputbox}>
                    <label>가격 : </label>
                    <input type="number" value={ price }
                        onChange={ e => dispatch({type: SET_PRICE, payload: e.target.value})}
                    />
                </div>
                <div>
                    <button onClick={ onClickHandler }>등록</button>
                    <button>취소</button>
                </div>
            </div>
        </>
    );
}
// 상품명, 상품등록일, 상품카테고리, 상품가격, 상품 상태번호
export default ProductRegist;