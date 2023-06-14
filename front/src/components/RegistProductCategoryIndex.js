import { useDispatch, useSelector } from "react-redux";
import { SET_CATEGORY } from "../modules/ProductRegistModule";


function RegistProductCategoryIndex({categoryInfo}) {

    const { category } = useSelector(state => state.productRegistReducer);
    const {productCategoryNo, productCategoryName} = categoryInfo;
    const dispatch = useDispatch();
    
    return(
        <option
            value={productCategoryNo}
        >
            {productCategoryName}
        </option>
      
    );
};

export default RegistProductCategoryIndex;