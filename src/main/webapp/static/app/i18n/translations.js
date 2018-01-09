var translations = {
	"pt-br": {
        // UserGroups
        "ADMIN": "Administradores",
        "MANAGER": "Gestores",
        "PRODUCTION": "Produção",
        "OPERATOR": "Operadores",

		"MEDIUM": "Média",
		"SEVERE": "Grave",
		"VERY_SEVERE": "Gravíssima",
			
		"SUNDAY": "Domingo",
		"MONDAY" : "Segunda",
		"TUESDAY" : "Terça",
		"WEDNESDAY" : "Quarta",
		"THURSDAY" : "Quinta",
		"FRIDAY" : "Sexta",
		"SATURDAY" : "Sábado",
		"ALL" : "Todos",

        // ContractStatus
        "ACTIVE": "Ativo",
        "EXPIRED": "Expirado",

        // EquipmentType
        "FIXED": "Fixo",
        "STATIC": "Estático",

        // EquipmentMode
        "STAND_BY": "Parado",
        "OPERATION": "Operando",
        "TEST": "Teste",

        // Validations
        "validation.minlength": "Número mínimo de caracteres não atingido.",
        "validation.equalto": "Os campos devem ser idênticos.",
        "validation.required": "Campo obrigatório.",
        "validation.number": "Somente números são permitidos.",

        // CameraModels
        "PUMATRONIX_ITSCAM_401": "Pumatronix Itscam 401",

        // CameraModes
        "SINGLE_CAPTURE": "Captura Simples",
        "CONTINUOUS_CAPTURE": "Captura Contínua",
        "TRIGGER_CAPTURE_IO": "Captura por IO",
        "TRIGGER_CAPTURE_APPROACHING": "Captura por Imagem (Aproximando)",
        "TRIGGER_CAPTURE_DEPARTING": "Captura por Imagem (Afastando)",

        // CameraTypes
        "ZOOM_APPROACHING": "ZA",
        "ZOOM_DEPARTING": "ZD",
        "PANORAMIC_APPROACHING": "PA",
        "PANORAMIC_DEPARTING": "PD",

        // SensorDetectionModes
        "APPROACHING": "Aproximando",
        "DEPARTING": "Afastando",

        // SensorOperationModes
        "VERTICAL": "Vertical",
        "HORIZONTAL": 'Horizontal',

        // RuleTypes
        "DEFAULT":"Passagem sem Infra\u00e7\u00e3o",
        "VELOCITY":"Velocidade",
        "LICENCE_PLATE_SCHEDULE":"Rod\u00EDzio de Ve\u00EDculos",
        "EXCLUSIVE_CIRCULATION_RIGHT":"Circula\u00e7\u00e3o Exclusiva Direita",
        "EXCLUSIVE_CIRCULATION_LEFT":"Circula\u00e7\u00e3o Exclusiva Esquerda",
        "PROHIBITED_TRUCK":"Caminh\u00E3o Proibido",
        "CROSSWALK_STOP":"Parada sobre Faixa",
        "ADVANCING_RED_PHASE":"Avanço de sinal Vermelho",
        "RETURN":"Retorno",
        "CONVERSION_RIGHT":"Conversão Direita",
        "CONVERSION_LEFT":"Conversão Esquerda",
        "STRETCH":"Trecho Percorrido",
        "LICENCE_PLATE_SCHEDULE_ZMRF":"Rod\u00EDzio de Fretamento",
        "LICENCE_PLATE_SCHEDULE_ZMRC":"Rod\u00EDzio de Caminh\u00f5es",

		 // User List
        "user_enabled_true": "Ativo",
        "user_enabled_false": "Inativo",

        //RuleTypes
        "DEFAULT":"Passagem sem Infração",
        "VELOCITY":"Velocidade",
        "LICENCE_PLATE_SCHEDULE":"Rodízio de Veículos",
        "EXCLUSIVE_CIRCULATION_RIGHT":"Cir. Exclusiva Direita",
        "EXCLUSIVE_CIRCULATION_LEFT":"Cir. Exclusiva Esquerda",
        "PROHIBITED_TRUCK":"Caminhão Proibido",
        "CROSSWALK_STOP":"Parada sobre Faixa",
        "ADVANCING_RED_PHASE":"Avanço de sinal Vermelho",
        "RETURN":"Retorno",
        "CONVERSION_RIGHT":"Conversão Direita",
        "CONVERSION_LEFT":"Conversão Esquerda",
        "STRETCH":"Trecho Percorrido",
        "LICENCE_PLATE_SCHEDULE_ZMRF":"Rodízio de Fretamento",
        "LICENCE_PLATE_SCHEDULE_ZMRC":"Rodízio de Caminhões",

        //RuleField
        "VELOCITY_SMALL":"PQ",
        "VELOCITY_MEDIUM":"MD",
        "VELOCITY_LARGE":"GD",
        "MONDAY":"SEG",
        "TUESDAY":"TER",
        "WEDNESDAY":"QUA",
        "THURSDAY":"QUI",
        "FRIDAY":"SEX",
        "SATURDAY":"SAB",
        "SUNDAY":"DOM",
        "DELAY_TIME":"Tempo de Retardo",
        "CAPTURE_ZOOM_ENTER":"Capturar Zoom Entrada",
        "CAPTURE_ZOOM_LEAVE":"Capturar Zoom Saída",
        "CAPTURE_PAN_ENTER":"Capturar Panorâmica Entrada",
        "CAPTURE_PAN_LEAVE":"Capturar Panorâmica Saída",
        "CAPTURE_VIDEO":"Capturar Vídeo",


        //InfractionLevel
        "MEDIUM":"Média",
        "SEVERE":"Grave",
        "VERY_SEVERE":"Gravíssima",


        //ObjectEvent

        "EQUIPEMENT_EVENT":"Equipamento",
        "SENSOR_INFO_EVENT":"Sensor",
        "CAMERA_INFO_EVENT":"Camera",
        "COMPONENT_INFO_EVENT":"Componente",
        "OPERATION_PLACE_EVENT":"Local",
        "LANE_EVENT":"Pista",
        "EQUIPMENT_CONFIGURATION":"Configuração Equipamento",
        "OCR_INFO_EVENT":"Ocr",

        "CREATE":"Criado",
        "UPDATE":"Atualizado",
        "DELETE":"Deletado",



        //Layout Tarja
        "LAYOUT_TYPE":"Tipo/Passagem",
        "PLACE_EXTERNAL_CODE":"Local Código",
        "PLACE_DESCRIPTION":"Local",
        "LANE_LABEL":"Pista",
        "DETECTION_DATE":"Data/Hora",
        "DETECTION_SEQUENCIAL":"Num. Sequencial",
        "DETECTION_VELOCITY":"Vel. Medida",
        "DETECTION_VELOCITY_CONSIDERED":"Vel. Consid.",
        "DETECTION_VELOCITY_REGULATED":"Vel. Regu.",
        "DETECTION_VELOCITY_TOLERACTED":"Vel. Infra.",
        "DETECTION_CLASSIFICATION":"Classifica\u00E7\u00E3o",
        "DETECTION_DISTANCE":"Distancia Capturada",
        "DETECTION_TIME_OCCUPATION":"Tempo Ocupa\u00E7\u00E3o",
        "DETECTION_INTERVAL":"Intervalo Detec\u00E7\u00E3o",
        "PLATE":"Placa",
        "LAW_NUMBER":"Enquadramento",
        "LAW_NUMBER_DESCRIPTION":"Enquadramento/Desc",
        "EQUIPMENT_CODE":"Cod. Equipamento",
        "EQUIPMENT_SERIAL":"Serial Equipament.",
        "INMETRO_CODE":"Inmetro",
        "INMETRO_VALIDATION_DATE":"Data Afer.",
        "ENTITY":"\u00D3rg\u00E3o",
        "DETECTION_FILE_NAME":"Arquivo",
        "OVD_CODE":"OVD",
        "OVD_DATE":"Data OVD",
        "INFRACTION_SEQUENCIAL":"Num. Infra\u00E7\u00E3o",
        "TIME_ADVANCE_TOLERANCE":"Avanço Tolerância",
        "TIME_ADVANCE":"Tempo Avanço",
        "STOP_TIME_TOLERANCE":"Tolerância Permanência",
        "STOP_TIME":"Permanência",
        "STOP_TOTAL_TIME":"Total Permanência",
        "IMAGE_TYPE":"Tipo Imagem",
        "CUSTOM_FIELD":"Campo Desc",


        //File Format
        "IMAGE":"Imagem",
        "FILE":"log",
        "VIDEO":"Vídeo",


        //File Separator
        "UNDERLINE":"_",
        "STRIPE":"-"

	}
};
