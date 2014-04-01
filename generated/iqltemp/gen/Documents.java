/////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2000-2014 Antenna Software Inc., All rights reserved //
//                                                                             //
// This file contains confidential information and is the                      //
// property of Antenna Software Inc., with all the restrictions                //
// therein.                                                                    //
/////////////////////////////////////////////////////////////////////////////////
package iqltemp.gen;
import  com.antennasoftware.api.foundation.vscript.VScriptRuntimeException;
import  com.antennasoftware.api.bl.document.DocumentResources;

public class Documents extends DocumentResources {
   protected Documents() {
      super();
      
   }
   
   protected Documents _D_Documents() {
      try {
         return this;
      } catch (Throwable _t_fini_0) {
         throw new VScriptRuntimeException("_D_Documents", _t_fini_0);
      }
      
   }
   
   protected Documents _Documents() {
      try {
         return this;
      } catch (Throwable _t_init_0) {
         throw new VScriptRuntimeException("_Documents", _t_init_0);
      }
      
   }
   
}
