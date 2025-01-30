\c nangpun

CREATE TABLE IF NOT EXISTS trade_history (
    id SERIAL PRIMARY KEY,
    stock_code VARCHAR(10) NOT NULL,
    action VARCHAR(10) NOT NULL,  -- 'buy' 또는 'sell'
    price FLOAT NOT NULL,
    quantity INT NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)