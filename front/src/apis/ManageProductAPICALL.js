import axios from 'axios';
import { getDateAndTime } from '../util/getTime';
import { getServerAddr } from '../util/getServerAddr';
import { POST_PRODUCT } from '../modules/ProductRegistModule';
import { GET_PRODUCT, GET_PRODUCTS } from '../modules/ProductFindModule';

export function registProductAPI(name, category, price) {
    const POST_PRODUCT_URL = getServerAddr() + '/products/regist';

    return async function registProduct(dispatch, getState) {
        let registInfo = {
            productName: name, 
            productCategory : {productCategoryNo: category},
            productStatus : {productStatusNo: 1},
            productDate: getDateAndTime(),
            productPrice: price};

        const result = await axios.post(POST_PRODUCT_URL, registInfo)
                                    .catch(err => console.log(err));

        dispatch({type:POST_PRODUCT, payload: result});
    };
};

export function findCategoriesAPI(dispatch_type) {

    const GET_REGIST_PRODUCT_URL = getServerAddr() + '/products/categories';

    return async function findRegistProductInfo(dispatch, getState) {

        const result = await axios.get(GET_REGIST_PRODUCT_URL).catch(err => console.log(err));

        dispatch({type: dispatch_type, payload: result});
    }
}

export function findProductsAPI(pageInfo) {
  const GET_PRODUCTS_URL = getServerAddr() + '/products';

  return async function findProducts(dispatch, getState) {
      
    const result = await axios.get(GET_PRODUCTS_URL, {params : { 
                                                                    page: pageInfo.page,
                                                                    totalItemCount: pageInfo.totalItemCount,
                                                                    pageItemCount: pageInfo.pageItemCount,
                                                                    categoryNo: pageInfo.categoryNo,
                                                                    statusNo: pageInfo.statusNo,
                                                                    searchValue: pageInfo.searchValue
                                                                  }
                                                          }
                                  ).catch(err => console.log(err));



    if(result.data != undefined){
        dispatch({type: GET_PRODUCTS, payload: result.data.data});
    }
  }
}

export function getProductInfoAPI(productNo) {
    const GET_PRODUCT_URL = getServerAddr() + '/products/' + productNo;

    return async function getProductInfo(dispatch, getState) {
            
            const result = await axios.get(GET_PRODUCT_URL).catch(err => console.log(err));

            dispatch({type: GET_PRODUCT, payload: result.data});
    }
}