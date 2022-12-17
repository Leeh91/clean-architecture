package br.com.audsat.utils;

import br.com.audsat.exceptions.ApplicationAppError;
import br.com.audsat.exceptions.IllegalArgumentAppException;

import javax.validation.*;
import java.util.Set;

/**
 * Efetua a auto-validação da classe que a estende pela chamada do método validateSelf.
 * TODO - Passar para interface com default methods
 * @param <T> Passar a própria classe de implementação como template como template
 */
public abstract class SelfValidating<T> {
    private Validator validator;

    public SelfValidating() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        /** TODO
         * Melhorar validator, para obter a instância do SpringValidator a partir do contexto do spring.
         * O código a seguir faz isso porém não funcionou com o JUnit, precisa injetar as dependências corretamente:
         *      SpringValidator validator = SpringContext.getBean(SpringValidator.class);
         * Também pode carregar as mensagens do bundle, que está no contexto do spring
         *      private MessageSourceAccessor msgBundle;
         *         msgBundle = SpringContext.getBean(MessageSourceAccessor.class);
         *         msgBundle.getMessage(MSG_TAG);
         */
    }

    /**
     * Evaluates all Bean Validations on the attributes of this
     * instance.
     */
    protected void validateSelf() {
        // O warning ocorre por haver cast de um template para a classe que extende esta, por definição,
        // a classe que estende esta deve passar a si própria como template, caso contrário irá ocorrer
        // exceção em tempo de execução.
        // TODO - Avaliar como tratar este warning
        @SuppressWarnings("unchecked")
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentAppException(
                    new ApplicationAppError("Erro na validação dos dados"),
                    new ConstraintViolationException(violations));
        }
    }
}