package tk.springlearning.springcloud.service;

public interface StorageService {
    void decrease(Long productId, Integer count);
}
