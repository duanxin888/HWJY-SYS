package com.duanxin.hwjy.infrastructure.client.news;

import java.util.List;
import java.util.Optional;

/**
 * @author duanxin
 * @version 1.0
 * @className NewsRequestClient
 * @date 2021/02/09 08:54
 */
public interface NewsRequestClient {

    Optional<List<NewsResponseDto>> fetchNews(NewsRequestDto dto);
}
