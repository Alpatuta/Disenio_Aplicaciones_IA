/**
 * VozSimple.js
 * Biblioteca simple para síntesis de voz
 * Optimizada para Chrome/Edge
 */

const VozSimple = {
    
    /**
     * Configuración por defecto
     */
    config: {
        lang: 'es-ES',
        volume: 1.0,
        rate: 0.8,
        pitch: 1.0
    },
    
    /**
     * Habla un texto usando Web Speech API
     * @param {string} texto - El texto a pronunciar
     * @param {Object} opciones - Opciones adicionales (opcional)
     */
    hablar: function(texto, opciones = {}) {
        if (!('speechSynthesis' in window)) {
            console.warn('Web Speech API no soportada en este navegador');
            return;
        }
        
        // Cancelar síntesis anterior
        speechSynthesis.cancel();
        
        // Crear utterance
        const utterance = new SpeechSynthesisUtterance(texto.toString());
        
        // Aplicar configuración
        utterance.lang = opciones.lang || this.config.lang;
        utterance.volume = opciones.volume || this.config.volume;
        utterance.rate = opciones.rate || this.config.rate;
        utterance.pitch = opciones.pitch || this.config.pitch;
        
        // Ejecutar síntesis
        speechSynthesis.speak(utterance);
    },
    
    /**
     * Detiene la síntesis de voz actual
     */
    parar: function() {
        if ('speechSynthesis' in window) {
            speechSynthesis.cancel();
        }
    },
    
    /**
     * Pausa la síntesis de voz
     */
    pausar: function() {
        if ('speechSynthesis' in window) {
            speechSynthesis.pause();
        }
    },
    
    /**
     * Reanuda la síntesis de voz
     */
    reanudar: function() {
        if ('speechSynthesis' in window) {
            speechSynthesis.resume();
        }
    },
    
    /**
     * Verifica si la síntesis de voz está disponible
     * @returns {boolean}
     */
    disponible: function() {
        return 'speechSynthesis' in window;
    },
    
    /**
     * Configura opciones por defecto
     * @param {Object} nuevaConfig - Nueva configuración
     */
    configurar: function(nuevaConfig) {
        this.config = { ...this.config, ...nuevaConfig };
    }
};

// Función global para compatibilidad
function hablarTexto(texto, opciones) {
    VozSimple.hablar(texto, opciones);
}

// Exportar para uso en módulos (si es necesario)
if (typeof module !== 'undefined' && module.exports) {
    module.exports = VozSimple;
}
