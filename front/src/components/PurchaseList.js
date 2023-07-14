import PurchaseListCSS from './PurchaseListCSS.module.css';

function PurchaseList({purchase}) {

  const {purchaseNo, productName, orderDate, amount, totalPrice} = purchase;
  console.log(purchase);
  return (
    <div className = {PurchaseListCSS.area}> 
                <tr 
                    // onClick={onClickHandler}
                    // onMouseOver={ () => onMouseOverHandler(productNo)}
                    // onMouseOut={ () => onMouseOutHandler(productNo)}
                    id={purchaseNo}
                >
                    <td>{productName}</td>
                    <td>{orderDate}</td>
                    <td>{amount}</td>
                    <td>{totalPrice}</td>
                    <td></td>
                </tr>
    </div>
  );
}

export default PurchaseList;