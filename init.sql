-- Create the database if it doesn't exist
CREATE DATABASE telemetry;

-- Connect to the database
\c telemetry;

CREATE TABLE IF NOT EXISTS telemetry_sensors (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'inactive',
    location VARCHAR(100) NOT NULL,
);

-- Create indexes for common queries
CREATE INDEX IF NOT EXISTS idx_sensors_type ON telemetry_sensor(type);
CREATE INDEX IF NOT EXISTS idx_sensors_location ON telemetry_sensor(location);
CREATE INDEX IF NOT EXISTS idx_sensors_status ON telemetry_sensor(status);

-- Create the telemetry_log table
CREATE TABLE IF NOT EXISTS telemetry_log (
    id SERIAL PRIMARY KEY,
	sensor_id INT,
    value FLOAT DEFAULT 0,
    unit VARCHAR(20),
    status VARCHAR(20) DEFAULT 'inactive',
    measurement VARCHAR(50),
    last_updated TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

-- Create indexes for common queries
CREATE INDEX IF NOT EXISTS idx_telemetry_log_sensor_id ON telemetry_log(sensor_id);
CREATE INDEX IF NOT EXISTS idx_telemetry_log_unit ON telemetry_log(unit);
CREATE INDEX IF NOT EXISTS idx_telemetry_status ON telemetry_log(status);
CREATE INDEX IF NOT EXISTS idx_telemetry_measurement ON telemetry_log(measurement);
