package by.oleg.service.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class CacheName {

    private String nameKey;
}
