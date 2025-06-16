package org.ezon.mall.controller;

import org.ezon.mall.entity.SellerWishlist;
import org.ezon.mall.service.WishSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wish/sellers")
public class WishSellerController {

    @Autowired
    private WishSellerService wishSellerService;

    public WishSellerController(WishSellerService wishSellerService) {
        this.wishSellerService = wishSellerService;
    }

    // 찜한 판매자 목록 조회
    @GetMapping
    public List<SellerWishlist> getWishSellers(@RequestParam Long userId) {
        return wishSellerService.getWishSellers(userId);
    }

    // 찜 토글(등록/해제)
    @PostMapping("/toggle")
    public boolean toggleWishSeller(@RequestParam Long userId, @RequestParam Long sellerUserId) {
        return wishSellerService.toggleWishSeller(userId, sellerUserId);
    }

    // 찜 해제
    @DeleteMapping("/{sellerUserId}")
    public void deleteWishSeller(@RequestParam Long userId, @PathVariable Long sellerUserId) {
        wishSellerService.deleteWishSeller(userId, sellerUserId);
    }
}
