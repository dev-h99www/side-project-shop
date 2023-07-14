import axios from "axios";
import { getServerAddr } from "../util/getServerAddr";
import { GET_PURCHASES, POST_PURCHASE } from "../modules/PurchaseModule";

export function registPurchaseAPI(purchaseInfo) {

  const POST_PURCHASE_URL = getServerAddr() + "/purchases";

  return async function registPurchase(dispatch, getState) {

    const result = await axios.post(POST_PURCHASE_URL, purchaseInfo).catch(err => console.log(err));
    dispatch({type:POST_PURCHASE, payload: result.data});
  }
}

export function getPurchasesAPI(searchInfo) {
  const GET_PURCHASES_URL = getServerAddr() + '/purchases';

  return async function getPurchases(dispatch, getState) {

    const result = await axios.get(GET_PURCHASES_URL, {params : {
      page: searchInfo.page,
      totalItemCount: searchInfo.totalItemCount,
      pageItemCount: searchInfo.pageItemCount,
      categoryNo: searchInfo.categoryNo,
      statusNo: searchInfo.statusNo,
      searchValue: searchInfo.searchValue,
      userNo: searchInfo.userNo

    }}).catch(err => console.log(err));

    if(result.data != undefined){
      dispatch({type:GET_PURCHASES, payload: result.data});
    }
  }
}