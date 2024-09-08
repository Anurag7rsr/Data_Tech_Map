import React from 'react'
import "./Style.css"
const Resturant = () => {
  return (
    <>
       <div className='card-container'>
        <div className='cards'>
          <div className='card-body'>
            <span className='card-number card circle subtile'>1</span>
            <span className='card-author subtile' style={{ color: 'red' }}>Breakfast</span>
            <h1 className='card-title'>Maggi</h1>
            <span className='card-description-subtile'>
              A quick and tasty meal of instant noodles, perfect for any time of the day.
            </span>
            <div className='card-read'>
              Read
            </div>
          </div>
          <div className='cards'>
          <div className='card-body'>
            <span className='card-number card circle subtile'>2</span>
            <span className='card-author subtile' style={{ color: 'red' }}>Tea</span>
            <h1 className='card-title'>Tea</h1>
            <span className='card-description-subtile'>
              A quick and tasty meal of instant Tea, perfect for any time of the day.
            </span>
            <div className='card-read'>
              Read
            </div>
          </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Resturant
