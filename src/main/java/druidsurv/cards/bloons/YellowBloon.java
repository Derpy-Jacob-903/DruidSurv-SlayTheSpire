package druidsurv.cards.bloons;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.bloons.BasicBloonPower;

import static druidsurv.ModFile.makeID;

public class YellowBloon extends AbstractEasyCard {
    public final static String ID = makeID("YellowBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public YellowBloon() {
        super(ID, 3, CardType.ATTACK, CardRarity.COMMON, CardTarget.SELF_AND_ENEMY, "YellowBloon_CardArt");
        baseDamage = 36;
        baseBlock = 5;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.BASIC);
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        bloonBlck();
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new BasicBloonPower(m, 1, damage), 1, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp()
    {
        upgradeDamage(14);
        upgradeBlock(5);
    }
}