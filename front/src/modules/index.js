import { combineReducers } from "redux";
import productRegistReducer from './ProductRegistModule';
import productFindReducer from "./ProductFindModule";
import memberReducer from "./MemberModule";
import purchaseReducer from "./PurchaseModule";

const rootReducer = combineReducers({
    productRegistReducer,
    productFindReducer,
    memberReducer,
    purchaseReducer,
});

export default rootReducer;