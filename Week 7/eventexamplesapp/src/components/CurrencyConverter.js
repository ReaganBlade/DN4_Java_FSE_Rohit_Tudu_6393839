import React, { useState } from "react";

const CurrencyConverter = () => {
  const [amount, setAmount] = useState(0);
  const [convertedAmount, setConvertedAmount] = useState(0);
  const [conversionRate, setConversionRate] = useState(0.011);

  return (
    <div>
      <h1>Currency Converter</h1>
      <div>
        Input In INR: 
        <span>
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(Number(e.target.value))}
            placeholder="Enter amount"
          />
        </span>
      </div>
      Convert to: 
      <select onChange={(e) => setConversionRate(Number(e.target.value))}>
        <option value="0.01142596">USD</option>
        <option value="0.009994004">EUR</option>
        <option value="0.008642295">GBP</option>
      </select>
      <h2>Final Amount: {convertedAmount.toFixed(2)}</h2>
      <button
        onClick={() =>
          setConvertedAmount(Number(amount) * Number(conversionRate))
        }
      >
        Convert
      </button>
      <button
        onClick={() => {
          setAmount(0);
          setConvertedAmount(0);
        }}
      >
        Reset
      </button>
      <p>Enter an amount in INR to convert it to another currency.</p>
      <p>Choose a currency from the dropdown to see the converted amount.</p>
    </div>
  );
};

export default CurrencyConverter;
