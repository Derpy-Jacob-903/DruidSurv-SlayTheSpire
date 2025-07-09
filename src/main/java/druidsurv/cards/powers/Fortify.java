package druidsurv.cards.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class Fortify extends AbstractEasyCard {
    public final static String ID = makeID("Fortify");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Fortify() {
        super(ID,0, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF, CharacterFile.Enums.STRIKER_COLOR, "Fortify_CardArt");
        baseMagicNumber = 2;
        magicNumber = baseMagicNumber;
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, new DexterityPower(p, magicNumber)));


        //CascadeHandler s = new CascadeHandler();
        //for (int i = 0; i < AbstractDungeon.getCurrRoom().monsters.monsters.size(); i++) {
            //AbstractMonster a = AbstractDungeon.getCurrRoom().monsters.monsters.get(i);
            //s.embiggen(m, magicNumber);
        //}
    }

    @Override
    public void upp() {
        upgradeMagicNumber(5);
    }
}