package com.go.backendgoproject_api.shared.mapping;
import com.go.backendgoproject_api.block.mapping.BlockMapper;
import com.go.backendgoproject_api.transaction.mapping.TransactionMapper;
import com.go.backendgoproject_api.user.mapping.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public TransactionMapper transactionMapper() {
        return new TransactionMapper();
    }

    @Bean
    public BlockMapper blockMapper() {
        return new BlockMapper();
    }
}
