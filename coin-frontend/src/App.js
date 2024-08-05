import axios from "axios";
import React from "react";

const body = {
  targetAmount: 7,
  coinDenominators: [0.1, 0.5, 1],
};

const ALLOWED_DENOMINATIONS = [
  0.01, 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 50, 100, 1000,
];

function App() {
  const [minCoins, setMinCoins] = React.useState([]);
  const [targetAmount, setTargetAmount] = React.useState("");
  const [coinDemo, setCoinDemo] = React.useState([]);
  const [targetErrorMsg, setTargetErrorMsg] = React.useState("");
  const [denoMsg, setDenoMsg] = React.useState("");
  const [serverText, setSeverText] = React.useState("");
  const onChangeSetTargetValue = (event) => {
    //TODO: target value
    //amount of money you need to make up to. Target amount must be within the range between 0 and 10,000.00
    const amount = parseFloat(event.target.value).toFixed(2);
    if (typeof amount === NaN) {
      setTargetErrorMsg("");
      return;
    }
    console.log(amount);
    if (amount >= 0 && amount <= 10000) {
      setTargetAmount(event.target.value);
    } else {
      if (amount !== null) {
        setTargetErrorMsg("Amount not in range of between 0 to 10000");
      }
    }
  };

  const onChangeSetDeno = (event) => {
    const str = event.target.value;
    const temp = str.split(",");
    for (let a in temp) {
      temp[a] = parseFloat(temp[a]).toFixed(2);
    }
    // temp.filter((n) => n);
    console.log(temp);
    setCoinDemo(temp);
    //write the log to set error msg for wrong input
    //extra comma
    //cannot have number that is not within the denomiation
  };

  const getHelloWordfromBE = async () => {
    try {
      //  `${process.env.REACT_APP_API_URL}`,does not work in build file
      const response = await axios.get("http://40.233.84.218:8080/hello");
      // console.log(response);
      setSeverText(response.data);
    } catch (e) {
      console.error(e);
    }
  };

  React.useEffect(() => {
    getHelloWordfromBE();
  });

  const getCoinCom = async () => {
    if (targetErrorMsg !== "") return;
    try {
      const response = await axios.post(
        "http://40.233.84.218:8080/hello",
        {
          targetAmount: targetAmount,
          coinDenominators: coinDemo,
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      // console.log("response", response);
      setMinCoins(response.data);
    } catch (e) {
      console.log(e);
    }
  };
  return (
    <div className="App">
      <h1>test env var</h1>
      {/* regardless of file name env.development, it will alawys be process.env to access it */}
      <p>You have connected with backend:{serverText}</p>
      <div>
        <label>
          targetAmount:
          <input
            type="number"
            name="targetAmount"
            onChange={onChangeSetTargetValue}
          />
        </label>
        <p>Error msg: {targetErrorMsg}</p>
      </div>

      <label>
        coin denominator:
        <input type="text" name="coinDenominators" onChange={onChangeSetDeno} />
      </label>
      <p>Error msg: {denoMsg}</p>
      <div>
        <button onClick={getCoinCom}>get coin combination</button>
      </div>
      <p>The mininum combination of coins needed for your input</p>
      <div>{minCoins.toString()}</div>

      <p>{targetErrorMsg === "" ? targetErrorMsg : null}</p>
    </div>
  );
}

export default App;
