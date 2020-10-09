// package apap.tutorial.haidokter.service;

// import apap.tutorial.haidokter.model.ResepModel;
// import java.util.ArrayList;
// import java.util.List;
// import org.springframework.stereotype.Service;

// @Service
// public class ResepInMemoryService implements ResepService{
//     private List<ResepModel> listResep;


//     public ResepInMemoryService() {
//         listResep = new ArrayList<>();
//     }

//     @Override
//     public void addResep(ResepModel resep) {
//         listResep.add(resep);
//     }

//     @Override
//     public List<ResepModel> getResepList() {
//         return listResep;
//     }

//     // @Override
//     // public  void deleteAll() {
//     //     listResep.clear();
//     // }
    
//     //  Todo
//     /*  Manfaatkan listResep sebagai searching space kamu, 
//         gunakan nomorResep sebagai kriteria untuk mencari.
//     */
//     @Override
//     public ResepModel getResepByNomorResep(Long nomorResep) {
//         ResepModel resep = new ResepModel();
//         for (int i = 0; i < listResep.size(); i++) {
//             ResepModel cariResep = listResep.get(i);
//             Long noResep = cariResep.getNoResep();
//             if (noResep.equals(nomorResep)) {
//                 resep = cariResep;
//             }
//         }
//         return resep;
//     }

//     @Override
//     public ResepModel updateResep(ResepModel resepModel) {
//         return null;
//     }
// }
