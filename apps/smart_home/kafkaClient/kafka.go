package kafkaClient

import (
	"os"
	"log"
	"sync"
	"github.com/segmentio/kafka-go"
)

var (
	instance *kafka.Writer
	once     sync.Once
)

// GetWriter возвращает единственный экземпляр Kafka Writer
func GetWriter() *kafka.Writer {
	once.Do(func() {
		// Инициализация произойдет только 1 раз
        log.Printf("MVP mode is %v", os.Getenv("MVP"))
        if os.Getenv("MVP") == "1" {
            instance = &kafka.Writer{
                Addr:     kafka.TCP(os.Getenv("QUEUE_ADDRESS")),
                Topic:    "sensor-info",
                Balancer: &kafka.LeastBytes{},
            }
            log.Printf("Created queue connection to %v", os.Getenv("QUEUE_ADDRESS"))
        }
	})
	return instance
}

// CloseWriter закрывает соединение (вызывать при выходе из приложения)
func CloseWriter() error {
	if instance != nil {
		return instance.Close()
	}
	return nil
}
