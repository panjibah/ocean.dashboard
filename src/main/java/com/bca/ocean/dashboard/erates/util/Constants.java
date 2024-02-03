package com.bca.ocean.dashboard.erates.util;

public final class Constants {

    public static class TYPE {

        public static final String PAYMENT = "PAYMENT";
        public static final String COLLECTION = "COLLECTION";
        
    }
    
    public static class FEATURE {

        public static final String VA = "Virtual Account";
        public static final String ONEKLIK = "OneKlik";
        
    }

    
    public static class CHANNEL {

        public static final String KBB = "KBB";
        public static final String EDC = "EDC";
        public static final String MBANK = "MBANK";
        public static final String KBI = "KBI";
        public static final String KU = "KU";
        public static final String BDS = "BDS";
        public static final String CRM = "CRM";
        public static final String ATM = "ATM";
        
    }
    
    public static class CHANNEL_MAP {

        public static final String KBB = "KlikBCA Bisnis";
        public static final String EDC = "EDC";
        public static final String MBANK = "BCA Mobile";
        public static final String KBI = "KlikBCA Individu";
        public static final String KU = "Kiriman Uang";
        public static final String BDS = "Cabang";
        public static final String CRM = "ATM";
        public static final String ATM = "ATM";
        
    }

    public static class STATUS {
    	
        public static final String SUCCESS = "SUCCESS";
        public static final String FAILED = "FAILED";
        public static final String REVERSAL = "REVERSAL";
        public static final String FORCESETTLE = "FORCE SETTLE";
        public static final String RECONCILE = "RECONCILE";
        
    }
    
    public static class EXPORTSTATUS {
    	
        public static final String SUCCESS = "SUCCESS";
        public static final String ONGOING = "ONGOING";
        public static final String FAILED = "FAILED";
        
    }
    
    public static class ERRORCODE {
    	public static final String SUCCESS = "OCN-00-000";
    	public static final String DATANOTFOUND = "OCN-99-004";
    	public static final String METHODNOTALLOWED = "DAS-18-002";
    	public static final String SYSTEMUNAVAILABLE = "DAS-18-003";
    	public static final String COMPANYCODENOTFOUND = "DAS-18-004";
    	public static final String CORPORATEIDNOTFOUND = "DAS-18-005";
    	public static final String TRANSACTIONISNOTVA = "DAS-18-006";
    	public static final String COMPANYPROFILENOTFOUND = "DAS-18-007";
        public static final String INVALID_DATE= "DAS-18-008";
        public static final String INVALID_ACCESS= "DAS-18-009";
    }
    
    public static class ERRORMESSAGEID{
    	public static final String SUCCESS = "Transaksi sukses";
    	public static final String DATANOTFOUND = "Data tidak ditemukan";
    	public static final String METHODNOTALLOWED = "Metode tidak diizinkan";
    	public static final String SYSTEMUNAVAILABLE = "Sistem sedang tidak tersedia";
    	public static final String COMPANYCODENOTFOUND = "Company code tidak ditemukan";
    	public static final String CORPORATEIDNOTFOUND = "Corporate ID tidak ditemukan";
    	public static final String TRANSACTIONISNOTVA = "Transaksi bukan merupakan VA/OneKlik";
    	public static final String COMPANYPROFILENOTFOUND = "Company profile tidak ditemukan";
        public static final String INVALID_DATE = "Maaf, periode transaksi maksimal 30 hari";
        public static final String INVALID_ACCESS= "Maaf transaksi ada tidak dapat diproses";

    }
    
    public static class ERRORMESSAGEEN{
    	public static final String SUCCESS = "Transaction success";
    	public static final String DATANOTFOUND = "Data not found";
    	public static final String METHODNOTALLOWED = "Method not allowed";
    	public static final String SYSTEMUNAVAILABLE = "System unavailable";
    	public static final String COMPANYCODENOTFOUND = "Company code not found";
    	public static final String CORPORATEIDNOTFOUND = "Corporate ID not found";
    	public static final String TRANSACTIONISNOTVA = "Transaction is not VA/OneKlik";
    	public static final String COMPANYPROFILENOTFOUND = "Company profile not found";
        public static final String INVALID_DATE = "Sorry, maximum transaction periode is 30 days";
        public static final String INVALID_ACCESS= "Sorry, your transaction cant be processed";
    }
}
