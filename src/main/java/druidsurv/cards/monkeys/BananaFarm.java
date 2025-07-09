package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class BananaFarm extends AbstractEasyCard {
    public final static String ID = makeID("BananaFarm");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public BananaFarm() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF, "BananaFarm_CardArt");
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new EnergizedPower(p, 2), 2, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp()
    {
        upgradeBlock(5);
    }
}