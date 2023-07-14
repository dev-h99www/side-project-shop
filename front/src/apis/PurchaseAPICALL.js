import axios from "axios";
import { getServerAddr } from "../util/getServerAddr";
import { POST_PURCHASE } from "../modules/PurchaseModule";

export function registPurchaseAPI(purchaseInfo) {

  const POST_PURCHASE_URL = getServerAddr() + "/purchases";

  return async function registPurchase(dispatch, getState) {

    const result = await axios.post(POST_PURCHASE_URL, purchaseInfo).catch(err => console.log(err));
    dispatch({type:POST_PURCHASE, payload: result.data});
  }
}