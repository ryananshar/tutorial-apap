import React from "react";

export default function Item(props) {
    const {item, onChange} = props;
    const {judul, sinopsis, genre, rating, tahun, imgUrl, checked} = item;
    
    const handleChange = () => 
        !! onChange && onChange({... item, checked: !checked});

    return (
        <button 
            type="button"
            className="list-group-item list-group-item-action flex-column align-items-start w-100 mb-3"
            onClick={handleChange}
        >
            <div className="d-flex">
                <div className="d-flex align-items-center">
                    <img className="mr-3" alt={judul} src={imgUrl} />
                </div>
                <div>
                    <div className="d-flex justify-content-between align-items-center">
                        <h5 className="mb-1 font-weight-bold">
                            {judul} ({tahun})
                            {/* <input 
                                type="checkbox"
                                className="ml-2"
                                checked={checked}
                                onChange={handleChange}
                            /> */}
                        </h5>
                    </div>
                    <p className="font-weight-bold mb-0 text-md">Rating: {rating} / 10</p>
                    <p className="mb-0 text-sm text-secondary">{genre}</p>
                    <p className="mb-1 text-md">{sinopsis}</p>
                </div>                
            </div>            
        </button>
    );
}