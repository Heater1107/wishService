package org.ezon.mall.controller;

import org.ezon.mall.entity.ProductWishlist;
import org.ezon.mall.service.WishProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wish/products")
public class WishProductController {

    @Autowired
    private WishProductService wishProductService;

    public WishProductController(WishProductService wishProductService) {
        this.wishProductService = wishProductService;
    }

    // 찜 목록 조회
    @GetMapping
    public List<ProductWishlist> getWishProducts(@RequestParam Long userId) {
        return wishProductService.getWishProducts(userId);
    }

    // 찜 토글(등록/해제)
    @PostMapping("/toggle")
    public boolean toggleWishProduct(@RequestParam Long userId, @RequestParam Long productId) {
        return wishProductService.toggleWishProduct(userId, productId);
    }

    // 찜 해제
    @DeleteMapping("/{productId}")
    public void deleteWishProduct(@RequestParam Long userId, @PathVariable Long productId) {
        wishProductService.deleteWishProduct(userId, productId);
    }
}
