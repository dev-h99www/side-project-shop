import { combineReducers } from "redux";
import productRegistReducer from './ProductRegistModule';
import productFindReducer from "./ProductFindModule";
import memberReducer from "./MemberModule";

const rootReducer = combineReducers({
    productRegistReducer,
    productFindReducer,
    memberReducer
});

export default rootReducer;