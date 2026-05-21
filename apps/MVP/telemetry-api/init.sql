-- Connect to the database
\c telemetry;

-- Create the sensors table
CREATE TABLE IF NOT EXISTS telemetry_sensor (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    location VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'inactive'
);

CREATE TABLE IF NOT EXISTS telemetry_log (
    id SERIAL PRIMARY KEY,
    sensor_id INTEGER REFERENCES telemetry_sensor(id),
    status VARCHAR(20) NOT NULL DEFAULT 'inactive',
    value FLOAT,
    unit VARCHAR(20),
    measurement VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_telemetry_sensor_id ON telemetry_log(sensor_id);
CREATE INDEX IF NOT EXISTS idx_telemetry_created_at ON telemetry_log(created_at);
CREATE INDEX IF NOT EXISTS idx_telemetry_sensor_time ON telemetry_log(sensor_id, created_at DESC);
