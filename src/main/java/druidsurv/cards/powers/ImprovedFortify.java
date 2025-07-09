package druidsurv.cards.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.EntanglePower;
import com.megacrit.cardcrawl.powers.NoBlockPower;
import com.megacrit.cardcrawl.powers.NoDrawPower;
import com.megacrit.cardcrawl.powers.watcher.NoSkillsPower;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class ImprovedFortify extends AbstractEasyCard {
    public final static String ID = makeID("ImprovedFortify");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public ImprovedFortify() {
        super(ID,0, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF, "ImprovedFortification_CardArt");
        baseMagicNumber = 6;
        magicNumber = baseMagicNumber;
        exhaust = true;
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, new DexterityPower(p, magicNumber)));
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, new NoBlockPower(p, 2, false)));

        //CascadeHandler s = new CascadeHandler();
        //for (int i = 0; i < AbstractDungeon.getCurrRoom().monsters.monsters.size(); i++) {
            //AbstractMonster a = AbstractDungeon.getCurrRoom().monsters.monsters.get(i);
            //s.improvedFortify(m, magicNumber);
        //}
    }

    @Override
    public void upp() {
        upgradeMagicNumber(5);
    }
}