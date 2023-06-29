function ProductStatusIndex({statusInfo}) {
    const {statusNo, statusName} = statusInfo;
    
    return(
        <option
            value={statusNo}
        >
             {statusName}
        </option>
    );
};

export default ProductStatusIndex;