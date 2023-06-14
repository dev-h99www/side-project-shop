import {GET_REGIST_PRODUCT, POST_PRODUCT} from '../modules/ProductRegistModule';

import axios from 'axios';
import { getDateAndTime } from '../util/getTime';
import { getServerAddr } from '../util/getServerAddr';

export function registProductAPI(name, category, price) {
    const POST_PRODUCT_URL = getServerAddr() + '/product/regist';

    return async function registProduct(dispatch, getState) {
        let registInfo = {
            productName: name, 
            productCategoryNo: category, 
            productStatusNo: 1,
            productDate: getDateAndTime(),
            productPrice: price};

        const result = await axios.post(POST_PRODUCT_URL, registInfo)
                                    .catch(err => console.log(err));

        dispatch({type:POST_PRODUCT, payload: result});
    };
};

export function findRegistProductInfoAPI() {

    const GET_REGIST_PRODUCT_URL = getServerAddr() + '/product/regist';

    return async function findRegistProductInfo(dispatch, getState) {

        const result = await axios.get(GET_REGIST_PRODUCT_URL).catch(err => console.log(err));

        dispatch({type: GET_REGIST_PRODUCT, payload: result});
    }
}